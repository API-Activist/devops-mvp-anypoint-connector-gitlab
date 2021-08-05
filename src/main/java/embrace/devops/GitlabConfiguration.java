package embrace.devops;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;

@Operations(GitlabOperations.class)
public class GitlabConfiguration {
	@Parameter
	private String url;
	@Parameter
	private String pat;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPAT() {
		return pat;
	}
	public void setPAT(String pat) {
		this.pat = pat;
	}

}
