/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl

import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class MyDslRuntimeModule extends AbstractMyDslRuntimeModule {
	public override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return typeof(ImportUriGlobalScopeProvider)
	}
}
