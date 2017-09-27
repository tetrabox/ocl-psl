package org.xtext.example.mydsl.util

import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory
import org.xtext.example.mydsl.myDsl.AlwaysProperty
import org.xtext.example.mydsl.myDsl.BeforeProperty
import org.xtext.example.mydsl.myDsl.BooleanOrOCLLiteral
import org.xtext.example.mydsl.myDsl.ImpliesProperty
import org.xtext.example.mydsl.myDsl.MyDslFactory
import org.xtext.example.mydsl.myDsl.NeverSequenceProperty
import org.xtext.example.mydsl.myDsl.NextEventAProperty
import org.xtext.example.mydsl.myDsl.OrBooleanPropertyProperty
import org.xtext.example.mydsl.myDsl.OverlappingUntilProperty
import org.xtext.example.mydsl.myDsl.Property
import org.xtext.example.mydsl.myDsl.SuffixImplicationProperty
import org.xtext.example.mydsl.myDsl.UntilProperty

class PropertyRewriter {
	
	private def createBooleanLiteral(boolean value) {
		return MyDslFactory.eINSTANCE.createBooleanLiteral => [
			literal = EssentialOCLCSFactory.eINSTANCE.createBooleanLiteralExpCS => [
				symbol = if (value) "true" else "false"
			]
		]
	}
	
	private def createNotBooleanLiteral(BooleanOrOCLLiteral literal) {
		return MyDslFactory.eINSTANCE.createNotBooleanOrOCLLiteral => [it.literal = literal]
	}
	
	private def createBooleanProperty(BooleanOrOCLLiteral literal) {
		return MyDslFactory.eINSTANCE.createBooleanProperty => [operand = literal]
	}
	
	
	/*
	 * b || p ==> {~b} |-> p
	 */
	public def Property rewrite(OrBooleanPropertyProperty in) {
		val result = MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createNotBooleanOrOCLLiteral => [
						literal = in.left
					]
				]
			]
			right = in.right
		]
		
		return result
	}
	
	/*
	 * b -> p ==> {b} |-> p
	 */
	public def Property rewrite(ImpliesProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += in.left
				]
			]
			right = in.right
		]
	}
	
	/*
	 * s |=> p ==> {s;true} |-> p
	 */
	public def Property rewrite(SuffixImplicationProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += in.left
					expressions += true.createBooleanLiteral
				]
			]
			right = in.right
		]
	}
	
	/*
	 * always p ==> {[+]} |-> p
	 */
	public def Property rewrite(AlwaysProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createLengthOne
				]
			]
			right = in.operand
		]
	}
	
	/*
	 * {[+];s} |-> false
	 */
	public def Property rewrite(NeverSequenceProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createLengthOne
					expressions += in.operand
				]
			]
			right = false.createBooleanLiteral.createBooleanProperty
		]
	}
	
	/*
	 * p until b ==> {(~b)[+]} |-> p
	 */
	public def Property rewrite(UntilProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createBooleanConsecutiveRepetition => [
						expression = in.right.createNotBooleanLiteral
					]
				]
			]
			right = in.left
		]
	}
	
	/*
	 * p until b ==> {{(~b)[+]}|{b[->]}} |-> p
	 */
	public def Property rewrite(OverlappingUntilProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createSEREOr => [
						left = MyDslFactory.eINSTANCE.createBracedSERE => [
							expression = MyDslFactory.eINSTANCE.createSERE => [
								expressions += MyDslFactory.eINSTANCE.createBooleanConsecutiveRepetition => [
									expression = in.right.createNotBooleanLiteral
								]
							]
						]
						right = MyDslFactory.eINSTANCE.createBracedSERE => [
							expression = MyDslFactory.eINSTANCE.createSERE => [
								expressions += MyDslFactory.eINSTANCE.createBooleanCountedGotoRepetition => [
									expression = in.right
								]
							]
						]
					]
				]
			]
			right = in.left.createBooleanProperty
		]
	}
	
	/*
	 * next_event_a(b)[k:l](p) ==> {b[->k:l]} |-> p
	 */
	public def Property rewrite(NextEventAProperty in) {
		return MyDslFactory.eINSTANCE.createOverlappingSuffixImplicationProperty => [
			left = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createBooleanCountedGotoRepetition => [
						expression = in.left
						count = in.range
					]
				]
			]
			right = in.right
		]
	}
	
	/*
	 * b1 before b2 ==> {(~b1 & ~b2)[*] ; (b1 & ~b2)}
	 */
	public def Property rewrite(BeforeProperty in) {
		return MyDslFactory.eINSTANCE.createSequenceProperty => [
			operand = MyDslFactory.eINSTANCE.createBracedSERE => [
				expression = MyDslFactory.eINSTANCE.createSERE => [
					expressions += MyDslFactory.eINSTANCE.createSequenceCountedConsecutiveRepetition => [
						expression = MyDslFactory.eINSTANCE.createBracedSERE => [
							expression = MyDslFactory.eINSTANCE.createSERE => [
								
							]
						]
					]
					expressions += MyDslFactory.eINSTANCE
				]
			]
		]
	}
}