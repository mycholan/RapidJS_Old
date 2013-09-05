var RapidCrud = function(){
	this.GetApplicationObj = function(id, appname, apptype, active){
		return {
			id : id,
	        appName : appname,
	        appType : apptype,
	        active : active
		};
	};
	this.TabHandler = null;
	
	this.GetMainTabMetaData = function() {
		RequestObject = new CreateRequestObject("META", "BASE", "NO", 0, 0, "", "", [], [], [], []);
		Communicator("_MainTabCallBack");
	};
	
	this.DisplayMainTab = function() {
		if(ResponseObject == null){	
			AlertObj.AlertUser("Factory Tab Meta Data", "something went wrong.!");
			return;
		}
		
		ResetView();
		var factoryMainDiv = $("#FactoryMainDiv");
		factoryMainDiv.html("");
		factoryMainDiv.show();
		factoryMainDiv.append($('<div id="CrudAreaDiv" class="CrudAreaDiv"></div>'));
		this.TabHandler = new FactoryTabHandler();		
		this.TabHandler.InitMainTabBar(ResponseObject, $("#CrudAreaDiv"));
	};
	
	this.GetSubTabMetaData = function(TabEntity) {
		this.TabHandler.CurrentTab = TabEntity;
		RequestObject = new CreateRequestObject("META", "SUBTAB", "NO", 0, 0, "", "", [], [], [], []);
		Communicator("_SubTabCallBack");
	};
	
	this.DisplaySubTab = function() {
		if(ResponseObject == null){	
			AlertObj.AlertUser("Factory Tab Meta Data", "something went wrong.!");
			return;
		}
		
		ResetView();
		$("#FactoryMainDiv").show();
		this.TabHandler.InitSubTabBar(ResponseObject);
	};
	
	this.GetTabChildMetaData = function(maintab) {
		RequestObject = new CreateRequestObject("META", maintab, "NO", 0, 0, "", "", [], [], [], []);
		Communicator("_TabContentCallBack");
	};
	
	this.DisplayTabChild = function() {
		if(ResponseObject == null){	
			AlertObj.AlertUser("Factory Tab Child Meta Data", "something went wrong.!");
			return;
		}
		
		console.log(JSON.stringify(ResponseObject));
	};
	
	this.PrepareApplicationTab = function() {
		
	};
	
	this.PrepareWindowTab = function(){
		
	};
	
	this.PrepareContainerTab = function(){
		
	};
	
	this.PrepareLayoutTab = function(){
		
	};
	
	this.PrepareToolbarTab = function(){
		
	};
	
	this.PrepareViewTab = function(){
		
	};
};