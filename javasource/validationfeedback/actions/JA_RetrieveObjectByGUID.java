// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package validationfeedback.actions;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class JA_RetrieveObjectByGUID extends CustomJavaAction<IMendixObject>
{
	private java.lang.Long ObjectGUID;
	private java.lang.String ExpectedEntity;

	public JA_RetrieveObjectByGUID(IContext context, java.lang.Long ObjectGUID, java.lang.String ExpectedEntity)
	{
		super(context);
		this.ObjectGUID = ObjectGUID;
		this.ExpectedEntity = ExpectedEntity;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		
		this.assertParameters();
		
		IMendixObject object = Core.retrieveId(this.context(), Core.createMendixIdentifier(this.ObjectGUID));
		
		this.assertCorrectEntity(object);
		
		return object;
		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "JA_RetrieveObjectByGUID";
	}

	// BEGIN EXTRA CODE
	
	/**
	 * 
	 * Ensure that the required parameters are present.
	 * 
	 */
	private void assertParameters() {
		
		if (this.ObjectGUID == null) {
			throw new IllegalArgumentException("ObjectGUID cannot be empty");
		}
		
		if (this.ExpectedEntity == null || this.ExpectedEntity.equals("")) {
			throw new IllegalArgumentException("Expected Entity cannot be empty");
		}
		
	}
	
	private void assertCorrectEntity(IMendixObject object) {
		if (object != null && !Core.isSubClassOf(object.getType(), this.ExpectedEntity)) {
			throw new IllegalArgumentException("Object with GUID " + this.ObjectGUID + " should be of entity " + this.ExpectedEntity + ", but is of entity: " + object.getType());
		}
	}
	
	// END EXTRA CODE
}
