package embrace.devops;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;

public class GLParameterId {
	@Parameter
	@Expression(ExpressionSupport.SUPPORTED)
	@Optional(defaultValue = "Id")
	private String Id;
	
	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}


}
