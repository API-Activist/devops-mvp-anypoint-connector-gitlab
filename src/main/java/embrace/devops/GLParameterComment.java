package embrace.devops;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;

public class GLParameterComment {
	@Parameter
	@Expression(ExpressionSupport.SUPPORTED)
	@Optional(defaultValue = "Comment something here")
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
