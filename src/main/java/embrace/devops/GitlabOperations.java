package embrace.devops;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitlabOperations {

	private static final Logger LOGGER = LoggerFactory.getLogger(GitlabOperations.class);
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-information")
	public String getProjects(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjects entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId;
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-issues")
	public String getProjectIssues(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectIssues entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-opened-issues")
	public String getProjectIssuesOpen(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectIssuesOpen entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues?state=opened";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-closed-issues")
	public String getProjectIssuesClosed(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectIssuesClosed entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues?state=closed";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-issues-by-ids")
	public String getProjectIssuesByIds(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="Ids") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectIssuesByIds entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues?iids[]=" + GLIdParam.getId();
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-issues-notes")
	public String getProjectIssuesNotes(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="Ids") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectIssuesNotes entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "/notes";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("List-all-project-members")
	public String getProjectMembers(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectMembers entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/members";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("List-all-project-users")
	public String getProjectUsers(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectMembers entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/users";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	
	
	@MediaType(value = ANY, strict = false)
	@Alias("Comment-on-project-issue")
	public String CommentOnIssue(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="Ids") GLParameterId GLIdParam, @ParameterGroup(name="Comment") GLParameterComment GLComment) throws IOException, InterruptedException {
    	LOGGER.info("GitLab CommentOnIssue entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "/notes?body=" + GLComment.getComment().replace(" ", "%20");
		
		responseBody = sentRequestwoPayload(GLConfig, url);

		return responseBody;
		
		
	}	
	
	
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-issue-statistics")
	public String getProjectIssueStats(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectIssueStats entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues_statistics";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-pipelines")
	public String getProjectPipelines(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectPipelines entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/pipelines";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-pipeline-by-id")
	public String getProjectPipelineById(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="PipelineId") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectPipelineById entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/pipelines/" + GLIdParam.getId();
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	


	@MediaType(value = ANY, strict = false)
	@Alias("Get-project-pipeline-variables")
	public String getProjectPipelineVars(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="PipelineId") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectPipelineVars entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/pipelines/" + GLIdParam.getId() + "/variables";
		
		responseBody = getRequest(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Create-issue-with-label")
	public String createIssueWithLabel(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="Title") GLParameterTitle GLTitle, @ParameterGroup(name="Label") GLParameterLabel GLLabel) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectPipelineVars entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues?title=" + GLTitle.getTitle().replace(" ", "%20")  + "&labels=" + GLLabel.getLabel().replace(" ", "%20")  + "&issue_type=issue" ;
		
		responseBody = sentRequestwoPayload(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Create-incident-with-label")
	public String createIIncidentWithLabel(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="Title") GLParameterTitle GLTitle, @ParameterGroup(name="Label") GLParameterLabel GLLabel) throws IOException, InterruptedException {
    	LOGGER.info("GitLab getProjectPipelineVars entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues?title=" + GLTitle.getTitle().replace(" ", "%20")  + "&labels=" + GLLabel.getLabel().replace(" ", "%20") + "&issue_type=incident" ;
		
		responseBody = sentRequestwoPayload(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Close-issue-by-id")
	public String CloseIssueById(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="IssueId") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab CloseIssueById entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "?state_event=close" ;
		
		responseBody = sentRequestUpdatewoPayload(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Reopen-issue-by-id")
	public String ReopenIssueById(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="IssueId") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab ReopenIssueById entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "?state_event=reopen" ;
		
		responseBody = sentRequestUpdatewoPayload(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Clear-labels-on-issue-by-id")
	public String ClearLabelIssueById(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="IssueId") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab ClearLabelIssueById entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "?labels=" ;
		
		responseBody = sentRequestUpdatewoPayload(GLConfig, url);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Add-label-on-issue-by-id")
	public String AddLabelIssueById(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="IssueId") GLParameterId GLIdParam, @ParameterGroup(name="Label") GLParameterLabel GLLabel) throws IOException, InterruptedException {
    	LOGGER.info("GitLab AddLabelIssueById entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "?labels=" + GLLabel.getLabel().replace(" ", "%20") ;
		
		responseBody = sentRequestUpdatewoPayload(GLConfig, url);

		return responseBody;
		
		
	}	


	@MediaType(value = ANY, strict = false)
	@Alias("Update-issue-using-field-query")
	public String UpdateIssueByIdFieldQuery(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="IssueId") GLParameterId GLIdParam, @ParameterGroup(name="Field Query") GLParameterFieldQuery GLFQuery) throws IOException, InterruptedException {
    	LOGGER.info("GitLab UpdateIssueByIdFieldQuery entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() + "?" + GLFQuery.getFieldQuery() ;
		
		responseBody = sentRequestUpdatewoPayload(GLConfig, url);

		return responseBody;
		
		
	}	


	@MediaType(value = ANY, strict = false)
	@Alias("Delete-issue")
	public String DeleteIssueById(@Config GitlabConfiguration GLConfig, @ParameterGroup(name="Project") GLParameterProject GLParams, @ParameterGroup(name="IssueId") GLParameterId GLIdParam) throws IOException, InterruptedException {
    	LOGGER.info("GitLab DeleteIssueById entered");  		

		String responseBody;
		String url_in = GLConfig.getUrl();
		String projectId = GLParams.getProjectId();
    	String url = url_in + "/api/v4/projects/" + projectId + "/issues/" + GLIdParam.getId() ;
		
		responseBody = sentRequestDelete(GLConfig, url);

		return responseBody;
		
		
	}	

	
	
	private String getRequest(@Config GitlabConfiguration GitLabConfig, String GLURL) throws IOException, InterruptedException {

		StringBuilder responseBodyReturn;
		int responseCode = 0;
		
		String pat = GitLabConfig.getPAT();

		
    	URL url = new URL(GLURL);
    	LOGGER.info("GitLab Request-url: " + url);  		
    	
    	URLConnection conn = url.openConnection();

    	if(conn instanceof HttpsURLConnection){
			LOGGER.info("Processing HTTPS request");
			HttpsURLConnection https = (HttpsURLConnection) conn;
	    	https.setRequestMethod("GET");
	    	https.addRequestProperty("Accept", "*/*");
	    		    	
	    	https.setRequestProperty ("PRIVATE-TOKEN", pat);
        	responseCode = https.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = https.getInputStream();
            } else {
                inputStream = https.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();
            
            responseBodyReturn = responseBody;

    	} 
    	else {
    		LOGGER.info("Processing HTTP request");
        	HttpURLConnection http = (HttpURLConnection) conn;
        	http.setRequestMethod("GET");
        	http.addRequestProperty("Accept", "*/*");
        	
	    	http.setRequestProperty ("PRIVATE-TOKEN", pat);
        	
        	responseCode = http.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = http.getInputStream();
            } else {
                inputStream = http.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();

            responseBodyReturn = responseBody;
    	}

    	

    	
    	LOGGER.info("GitLab ReturnCode: " + String.valueOf(responseCode));
    	

		return responseBodyReturn.toString();
		
		
	}	


	private String sentRequestwoPayload(@Config GitlabConfiguration GitLabConfig, String GLURL) throws IOException, InterruptedException {

		StringBuilder responseBodyReturn;
		int responseCode = 0;
		
		String pat = GitLabConfig.getPAT();

		
    	URL url = new URL(GLURL);
    	LOGGER.info("GitLab Request-url: " + url);  		
    	
    	URLConnection conn = url.openConnection();

    	if(conn instanceof HttpsURLConnection){
			LOGGER.info("Processing HTTPS request");
			HttpsURLConnection https = (HttpsURLConnection) conn;
	    	https.setRequestMethod("POST");
	    	https.addRequestProperty("Accept", "*/*");
	    		    	
	    	https.setRequestProperty ("PRIVATE-TOKEN", pat);
        	responseCode = https.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = https.getInputStream();
            } else {
                inputStream = https.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();
            
            responseBodyReturn = responseBody;

    	} 
    	else {
    		LOGGER.info("Processing HTTP request");
        	HttpURLConnection http = (HttpURLConnection) conn;
        	http.setRequestMethod("POST");
        	http.addRequestProperty("Accept", "*/*");
        	
	    	http.setRequestProperty ("PRIVATE-TOKEN", pat);
        	
        	responseCode = http.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = http.getInputStream();
            } else {
                inputStream = http.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();

            responseBodyReturn = responseBody;
    	}

    	

    	
    	LOGGER.info("GitLab ReturnCode: " + String.valueOf(responseCode));
    	

		return responseBodyReturn.toString();
		
		
	}	


	private String sentRequestUpdatewoPayload(@Config GitlabConfiguration GitLabConfig, String GLURL) throws IOException, InterruptedException {

		StringBuilder responseBodyReturn;
		int responseCode = 0;
		
		String pat = GitLabConfig.getPAT();

		
    	URL url = new URL(GLURL);
    	LOGGER.info("GitLab Request-url: " + url);  		
    	
    	URLConnection conn = url.openConnection();

    	if(conn instanceof HttpsURLConnection){
			LOGGER.info("Processing HTTPS request");
			HttpsURLConnection https = (HttpsURLConnection) conn;
	    	https.setRequestMethod("PUT");
	    	https.addRequestProperty("Accept", "*/*");
	    		    	
	    	https.setRequestProperty ("PRIVATE-TOKEN", pat);
        	responseCode = https.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = https.getInputStream();
            } else {
                inputStream = https.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();
            
            responseBodyReturn = responseBody;

    	} 
    	else {
    		LOGGER.info("Processing HTTP request");
        	HttpURLConnection http = (HttpURLConnection) conn;
        	http.setRequestMethod("PUT");
        	http.addRequestProperty("Accept", "*/*");
        	
	    	http.setRequestProperty ("PRIVATE-TOKEN", pat);
        	
        	responseCode = http.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = http.getInputStream();
            } else {
                inputStream = http.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();

            responseBodyReturn = responseBody;
    	}

    	

    	
    	LOGGER.info("GitLab ReturnCode: " + String.valueOf(responseCode));
    	

		return responseBodyReturn.toString();
		
		
	}	

	private String sentRequestDelete(@Config GitlabConfiguration GitLabConfig, String GLURL) throws IOException, InterruptedException {

		StringBuilder responseBodyReturn;
		int responseCode = 0;
		
		String pat = GitLabConfig.getPAT();

		
    	URL url = new URL(GLURL);
    	LOGGER.info("GitLab Request-url: " + url);  		
    	
    	URLConnection conn = url.openConnection();

    	if(conn instanceof HttpsURLConnection){
			LOGGER.info("Processing HTTPS request");
			HttpsURLConnection https = (HttpsURLConnection) conn;
	    	https.setRequestMethod("DELETE");
	    	https.addRequestProperty("Accept", "*/*");
	    		    	
	    	https.setRequestProperty ("PRIVATE-TOKEN", pat);
        	responseCode = https.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = https.getInputStream();
            } else {
                inputStream = https.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();
            
            responseBodyReturn = responseBody;

    	} 
    	else {
    		LOGGER.info("Processing HTTP request");
        	HttpURLConnection http = (HttpURLConnection) conn;
        	http.setRequestMethod("DELETE");
        	http.addRequestProperty("Accept", "*/*");
        	
	    	http.setRequestProperty ("PRIVATE-TOKEN", pat);
        	
        	responseCode = http.getResponseCode();
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = http.getInputStream();
            } else {
                inputStream = http.getErrorStream();
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    inputStream));

            StringBuilder responseBody = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null) 
            	responseBody.append(currentLine);

            in.close();

            responseBodyReturn = responseBody;
    	}

    	

    	
    	LOGGER.info("GitLab ReturnCode: " + String.valueOf(responseCode));
    	

		return responseBodyReturn.toString();
		
		
	}	


}
