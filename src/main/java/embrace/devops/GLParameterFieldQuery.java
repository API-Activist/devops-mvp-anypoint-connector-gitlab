package embrace.devops;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;

public class GLParameterFieldQuery {
	@Parameter
	@Expression(ExpressionSupport.SUPPORTED)
	@Optional(defaultValue = "labels=FieldQuery&labels=ITM,DevOps,CICD&description=Its a sample desc here")
	private String fieldquery;
	
	public String getFieldQuery() {
		return fieldquery;
	}

	public void setFieldQuery(String fieldquery) {
		this.fieldquery = fieldquery;
	}


}
