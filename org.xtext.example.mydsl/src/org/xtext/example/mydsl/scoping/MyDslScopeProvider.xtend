/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.ocl.xtext.basecs.ConstraintCS
import org.eclipse.xtext.scoping.Scopes
import org.xtext.example.mydsl.myDsl.Document
import org.xtext.example.mydsl.myDsl.MyDslPackage

class MyDslScopeProvider extends AbstractMyDslScopeProvider {
	override def getScope(EObject context, EReference reference) {
		if (reference == MyDslPackage.Literals.OCL_LITERAL__LITERAL) {
			var root = context
			while (!(root instanceof Document)) {
				root = root.eContainer
			}
			val document = root as Document
			val allContent = newArrayList
			document.ownedImports.map[
				val resource = ResourceUtils.openImport(it.eResource, it.importURI)
				resource.allContents.filter[
					it instanceof ConstraintCS
				]
			].forEach[l|
				l.forEach[o|
					allContent += o
				]
			]
			return Scopes.scopeFor(allContent)
		}
		return super.getScope(context, reference);
	}
}
