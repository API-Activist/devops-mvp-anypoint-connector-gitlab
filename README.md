# DevOps MVP Anypoint Connector GitLab 
This is a simple opensource GitLab Connector for Anypoint Studio for exchanging issues using API-led connectivity in interaction with other systems such as Atlassian Jira, ServiceNow, ALM Octane, BMC Remedy, etc. 
This GitLab MVP connector is build as a template for the #MuleSoft #Community to extend, reuse and share.
Implementation content is focused on issues resources of GitLab. 

Use the GitLab REST API reference to extend this connector to your needs: https://docs.gitlab.com/ee/api/api_resources.html

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/max-gitlab.png)

## Getting started
This Anypoint Studio MVP (Minimum Viable Product) Connector for GitLab has been built for the MuleSoft Community as a template to reuse and if required further extend. 
The connector supports 17 operations in this MVP release with the focus on issues, which are:
- Add label on issue
- Clear labels on issue
- Close issue
- Comment on project issue
- Create incident with label
- Create issue with label
- Delete issue
- Get project closed issues
- Get project information
- Get project issue statistics
- Get project issues
- Get project issue by Ids
- Get project issues notes
- Get project opened issues
- List all project users
- Repoen issue by Id
- Update issue using field query


## Installation of the MVP Connector for GitLab
This section describes the installation process for this mvp connector in order to use in Anypoint Studio. 

### Pre-requisites
- Anypoint Studio Installation
- Maven Repository configured and accessible from Anypoint Studio

### Step 1 - Download the MVP GitLab Connector
- Download Repository as ZIP
- Unpack it to a preferred location, typically into your Anypoint Studio workspaces area

### Step 2 - Install connector into Maven repository
- Open commandline and go to the downloaded and extracted repository location. 
- Perform "mvn install" 
- Connector should be installed successfully

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/mvn-install.PNG)

### Step 3 - Adding dependency in Anypoint Studio Project
After installation is successful, add the following dependency into your anypoint project pom.xml:

		<dependency>
			<classifier>mule-plugin</classifier>
			<groupId>embrace.devops.connectors</groupId>
			<artifactId>gitlab-connector</artifactId>
			<version>0.1.15</version>
		</dependency>

The current version of this connector is 0.1.15. Once added, save the pom.xml file and your Mule Palette gets updated and you should see the GitLab connector.

![Image of Jenkins MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/00_mule_palette.PNG)

### Step 4 - Create GitLab Configuration
Before you get started and consume the provided operations, make sure to configure the GitLab Connection within Anypoint Studio. 
- Url - URL of GitLab installation (i.e. https://gitlab.com)
- PAT-Token (not password) - Get the Personal Access Token for the specified user - more Information: [Create PAT in GitLab](https://docs.gitlab.com/ee/user/profile/personal_access_tokens.html)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/01_configuration.PNG)

Now you are all set to use the GitLab Operations.

## Connector Operations - how to use
This section describes, how to use the provided operation for GitLab Connector.

**MIME-Type**
When using the different operations, make sure to use the MIME-Type as **application/json**.

### Operation 1: Add labels on issue
This operation adds one or multiple labels on an issue. The response is a json object containing **all information on the updated issue**.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id
- Label(s) - you can add multiple labels seperated by comma.

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/02_mime_type.PNG)


Before changing the record in Gitlab:
![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/03_add_label_on_issue_by_id_before-change.PNG)


After changing the record in Gitlab: 
![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/03_add_label_on_issue_by_id_after-change.PNG)

Also make sure to change the MIME Type to application/json for the **Add labels on issue** operation


**Example response**:
	{
	
		"id": 91450919,
		"iid": 13,
		"project_id": 28582507,
		"title": "Anypoint Platform CloudHub",
		"description": null,
		"state": "opened",
		"created_at": "2021-08-04T17:03:47.852Z",
		"updated_at": "2021-08-05T06:02:22.017Z",
		"closed_at": null,
		"closed_by": null,
		"labels": [
			"CICD",
			"DevOps"
		],
		...
	}


### Operation 2: Clears labels on issue
This operation clears all labels on a specified issue. The response is a json object containing **all information on the updated issue**.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/04_clear_label_on_issue_by_id.PNG)


**Example response**:
	{
	
		"id": 91450919,
		"iid": 13,
		"project_id": 28582507,
		"title": "Anypoint Platform CloudHub",
		"description": null,
		"state": "opened",
		"created_at": "2021-08-04T17:03:47.852Z",
		"updated_at": "2021-08-05T06:02:22.017Z",
		"closed_at": null,
		"closed_by": null,
		"labels": [],
		...
	}
	
	
### Operation 3: Close issue
This operation close the specified issue. The response is a json object containing **all information on the updated issue**.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/05_close_issue_by_id.PNG)


**Example response**:
	{
	
		"id": 91450919,
		"iid": 13,
		"project_id": 28582507,
		"title": "Anypoint Platform CloudHub",
		"description": null,
		"state": "closed",
		...
	}

	
### Operation 4: Comment on issue
This operation comments on the specified issue. The response is a json object containing **all information on the updated issue**.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id
- Comment

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/06_comment_on_issue_by_id.PNG)


**Example response**:
	{
	
    "id": 643672872,
    "type": null,
    "body": "Issue is fixed, ready for retest",
	...
	}
	

### Operation 5: Create Incident with Label
This operation creates an incident with label. The response is a json object containing **all information on the created incident**.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Title
- Label(s)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/07_create_incident_with_label.PNG)

Incident created in Gitlab:
![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/07_create_incident_with_label_gitlab_created.PNG)


**Example response**:
	{
	
		"id": 91491935,
		"iid": 14,
		"project_id": 28582507,
		"title": "Demo Mule SDK Plugin for GitLab",
		"description": null,
		"state": "opened",
		...
	}


### Operation 6: Create Issue with Label
This operation creates an issue with label. The response is a json object containing **all information on the created issue**.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Title
- Label(s)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/08_create_issue_with_label.PNG)

Issue created in Gitlab:
![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/08_create_issue_with_label_gitlab_created.PNG)


**Example response**:
	{
	
		"id": 91491936,
		"iid": 15,
		"project_id": 28582507,
		"title": "Demo Mule SDK Plugin for GitLab",
		"description": null,
		"state": "opened",
		...
	}

### Operation 7: Delete Issue
This operation deletes a specified issue. The response is empty on success with 200.

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/09_delete_issue.PNG)


**Example response**:
	{}
	
	
### Operations 8 [2 Operations] : Get project closed issues | Get project opened issues
This operation gets all opened|closed issues. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/10_get_rpoject_closed_issue.PNG)


**Example response**:

	[
		{
			"id": 91491935,
			"iid": 14,
			"project_id": 28582507,
			"title": "Demo Mule SDK Plugin for GitLab",
			"description": null,
			"state": "closed",
			...
		},
		{
			"id": 91491937,
			"iid": 13,
			"project_id": 28582507,
			"title": "Demo Mule SDK Plugin for GitLab 2",
			"description": null,
			"state": "closed",
			...
		}
	]

### Operation 9: Get project issue informations
This operation gets project information. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/11_get_project_info.PNG)


**Example response**:
	{
	
		"id": 28582507,
		"description": null,
		"name": "devops-mvp",
		"name_with_namespace": "Embrace-devops / devops-mvp",
		"path": "devops-mvp",
		"path_with_namespace": "embrace-devops/devops-mvp",
		"created_at": "2021-08-03T14:06:46.451Z",
		"default_branch": "main",
		...
	}
	
	
### Operation 10: Get project issue statistics
This operation get project issue statistics. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/12_get_project_issues_stats.PNG)


**Example response**:
	{
	
		"statistics": {
			"counts": {
				"all": 12,
				"closed": 2,
				"opened": 10
			}
		}
	}

	
### Operation 11: Get project issues
This operation gets all project issues. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)


**Example response**:
	[
	
		{
			"id": 91491935,
			"iid": 14,
			"project_id": 28582507,
			"title": "Demo Mule SDK Plugin for GitLab",
		...
		},
		{},
		{}
		...
	]

### Operation 12: Get project issue by Id
This operation gets project issue by Id. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id(s)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/13_get_project_issues_by_Ids.PNG)


**Example response**:
	[
	
		{
			"id": 91491935,
			"iid": 14,
			"project_id": 28582507,
			"title": "Demo Mule SDK Plugin for GitLab",
		...
		},
		{},
		{}
		...
	]

### Operation 13: Get project issue notes
This operation gets project issue notes. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/14_get_project_issue_notes.PNG)


**Example response**:
	[
	
		{
			"id": 644204821,
			"type": null,
			"body": "Tested still not fixed",
			...
		},
		{},
		{}
	]

### Operation 14: Get project users
This operation gets project users. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/15_get_project_users.PNG)


**Example response**:
	[
	
		{
			"id": 9439395,
			"name": "Amir Khan",
			"username": "a.khan.82.1",
			"state": "active",
			"avatar_url": "https://secure.gravatar.com/avatar/a669a44710546719e7d3cbfd1c1e85f6?s=80&d=identicon",
			"web_url": "https://gitlab.com/a.khan.82.1"
		},
		{},
		{}
	]

### Operation 15: Reopen Issue
This operation reopens project issue, which has been closed before. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/16_reopen_issue.PNG)


**Example response**:
	{
	
		"id": 91491935,
		"iid": 14,
		"project_id": 28582507,
		"title": "Demo Mule SDK Plugin for GitLab",
		"description": null,
		"state": "opened",
		...
	}
	
### Operation 16: Update Issue with Field Query
This operation updates issue with a field query. The query can include multiple field and values. 

To use this operation, drag and drop it to the canvas and provide:
- Connection properties for GitLab 
- Project Id (not name)
- Issue Id
- Field query 
	- format: <field>=<value>&<field>=<value>
	- example: Title=FieldQuery&labels=ITM,DevOps,CICD&description=Its a sample desc here

![Image of GitLab MuleSoft Connector](https://github.com/API-Activist/devops-mvp-anypoint-connector-gitlab/blob/master/pictures/16_update_issues_with_field_query.PNG)


**Example response**:
	{
	
		"id": 91491935,
		"iid": 14,
		"project_id": 28582507,
		"title": "FieldQuery",
		"description": "Its a sample desc here",
		"state": "opened",
		...
	}

## Video Tutorial
Link to the video tutorial: -to be provided soon-
	
## Caution
This connector has been build on windows 10 using the Anypoint Studio 7.10 IDE. It has only been tested with Gitlab Cloud. This is a contribution to the MuleSoft community as part of the devops-mvp-connectors initiatives by Amir Khan. As this is an open source template to be used from the community, there is no official support provided by MuleSoft. Also if operations are missing, please use the GitLab API references to implement using the examples provided within this template.
	
GitLab API Reference: https://docs.gitlab.com/ee/api/api_resources.html
	

### License agreement
By using this repository, you accept that Max the Mule is the coolest integrator on the planet
