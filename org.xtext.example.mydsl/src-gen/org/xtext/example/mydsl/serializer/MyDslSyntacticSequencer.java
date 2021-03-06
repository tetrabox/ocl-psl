/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MyDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_DefOperationCS_UnrestrictedNameParserRuleCall_2_q;
	protected AbstractElementAlias match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q;
	protected AbstractElementAlias match_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2;
	protected AbstractElementAlias match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q;
	protected AbstractElementAlias match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q;
	protected AbstractElementAlias match_Property_LeftParenthesisKeyword_6_0_q;
	protected AbstractElementAlias match_Property_LeftParenthesisKeyword_7_0_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MyDslGrammarAccess) access;
		match_DefOperationCS_UnrestrictedNameParserRuleCall_2_q = new TokenAlias(false, true, grammarAccess.getDefOperationCSAccess().getUnrestrictedNameParserRuleCall_2());
		match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q = new TokenAlias(false, true, grammarAccess.getDefPropertyCSAccess().getUnrestrictedNameParserRuleCall_2());
		match_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getImportCSAccess().getImportKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getImportCSAccess().getIncludeKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getImportCSAccess().getLibraryKeyword_0_2()));
		match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
		match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q = new TokenAlias(false, true, grammarAccess.getOperationContextDeclCSAccess().getUnrestrictedNameParserRuleCall_8_2_1());
		match_Property_LeftParenthesisKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getPropertyAccess().getLeftParenthesisKeyword_6_0());
		match_Property_LeftParenthesisKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getPropertyAccess().getLeftParenthesisKeyword_7_0());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getUnrestrictedNameRule())
			return getUnrestrictedNameToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * UnrestrictedName returns ecore::EString:
	 * 	EssentialOCLUnrestrictedName
	 * 						| 'import'
	 * 	| 'include'
	 * 			| 'library'
	 * 				;
	 */
	protected String getUnrestrictedNameToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_DefOperationCS_UnrestrictedNameParserRuleCall_2_q.equals(syntax))
				emit_DefOperationCS_UnrestrictedNameParserRuleCall_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q.equals(syntax))
				emit_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2.equals(syntax))
				emit_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q.equals(syntax))
				emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q.equals(syntax))
				emit_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Property_LeftParenthesisKeyword_6_0_q.equals(syntax))
				emit_Property_LeftParenthesisKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Property_LeftParenthesisKeyword_7_0_q.equals(syntax))
				emit_Property_LeftParenthesisKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'def' (ambiguity) ':' name=UnrestrictedName
	 *     (rule start) 'def' (ambiguity) ':' ownedSignature=TemplateSignatureCS
	 *     isStatic?='static' 'def' (ambiguity) ':' name=UnrestrictedName
	 *     isStatic?='static' 'def' (ambiguity) ':' ownedSignature=TemplateSignatureCS
	 */
	protected void emit_DefOperationCS_UnrestrictedNameParserRuleCall_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'def' (ambiguity) ':' name=UnrestrictedName
	 *     isStatic?='static' 'def' (ambiguity) ':' name=UnrestrictedName
	 */
	protected void emit_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'import' | 'include' | 'library'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=Identifier
	 *     (rule start) (ambiguity) ownedPathName=URIPathNameCS
	 */
	protected void emit_ImportCS_ImportKeyword_0_0_or_IncludeKeyword_0_1_or_LibraryKeyword_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '|?'?
	 *
	 * This ambiguous syntax occurs at:
	 *     lowerBound=LOWER (ambiguity) ']' (rule end)
	 *     stringBounds='*' (ambiguity) ']' (rule end)
	 *     stringBounds='+' (ambiguity) ']' (rule end)
	 *     stringBounds='?' (ambiguity) ']' (rule end)
	 *     upperBound=UPPER (ambiguity) ']' (rule end)
	 */
	protected void emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     UnrestrictedName?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedBodies+=SpecificationCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedParameters+=ParameterCS ')' ':' 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedPathName=PathNameCS '(' ')' ':' 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedPostconditions+=ConstraintCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedPreconditions+=ConstraintCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 *     ownedType=TypeExpCS 'body' (ambiguity) ':' ownedBodies+=SpecificationCS
	 */
	protected void emit_OperationContextDeclCS_UnrestrictedNameParserRuleCall_8_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'always' operand=Property
	 *     (rule start) (ambiguity) 'eventually!' operand=BooleanOrOCLLiteral
	 *     (rule start) (ambiguity) 'eventually!' operand=Sequence
	 *     (rule start) (ambiguity) 'never' operand=BooleanOrOCLLiteral
	 *     (rule start) (ambiguity) 'never' operand=Sequence
	 *     (rule start) (ambiguity) 'next_e' operand=BooleanOrOCLLiteral
	 *     (rule start) (ambiguity) operand=BooleanOrOCLLiteral
	 *     (rule start) (ambiguity) operand=Sequence
	 */
	protected void emit_Property_LeftParenthesisKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'next_event_a' '(' left=BooleanOrOCLLiteral
	 *     (rule start) (ambiguity) left=BooleanOrOCLLiteral
	 *     (rule start) (ambiguity) left=Sequence
	 */
	protected void emit_Property_LeftParenthesisKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='Tuple' (ambiguity) (rule end)
	 *     name='Tuple' (ambiguity) ownedMultiplicity=MultiplicityCS
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
