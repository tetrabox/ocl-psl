package org.xtext.example.mydsl.ui

import org.eclipse.xtext.resource.impl.AbstractResourceDescription

class PackageProvider extends AbstractResourceDescription {
	
	override protected computeExportedObjects() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getImportedNames() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getReferenceDescriptions() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getURI() {
		return org.eclipse.emf.common.util.URI.createPlatformResourceURI("neverland", true)
	}
	
}