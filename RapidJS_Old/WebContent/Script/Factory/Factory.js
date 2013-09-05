/*Global scope object factory object, which will be instantiated according to user selected factory category (CRUD, WF and CMS)*/
var FactoryObj = null;
/*Jquery UI Alert box object*/
var AlertObj = null;

$(document).ready(function(){
	AlertObj = new RapidAlertBox();
	
	$( "#CrudAreaDiv" ).tabs({
		activate: function( event, ui ) {
			var index = $(this).tabs( "option", "active" );
			//AlertObj.AlertUser("Tab Selected", "Youe have selected tab : "+index);
			var currentTabContent = $('.ui-tabs-active').find('a').attr('href');
			//AlertObj.AlertUser("Tab Selected", "Youe have selected tab : "+currentTabContent);
		}	 
	});		
	//$("#CrudAreaDiv").tabs("option", "active", 4);

	//AlertObj.AlertUser("Title here", "Message here");
	$("#CrudLink").click(function(){
		ResetView();
		InitCrud();
	});

	$("#WorkflowLink").click(function(){
		ResetView();
		InitWorkflow();
	});

	$("#CmsLink").click(function(){
		ResetView();
		InitCms();
	});


	//all hover and click logic for buttons
	$(".fg-button:not(.ui-state-disabled)")
	.hover(function(){ 
			$(this).addClass("ui-state-hover"); 
		},
		function(){ 
			$(this).removeClass("ui-state-hover"); 
		}
	)
	.mousedown(function(){
		$(this).parents('.fg-buttonset-single:first').find(".fg-button.ui-state-active").removeClass("ui-state-active");
		if( $(this).is('.ui-state-active.fg-button-toggleable, .fg-buttonset-multi .ui-state-active') ){ $(this).removeClass("ui-state-active"); }
		else { $(this).addClass("ui-state-active"); }	
	})
	.mouseup(function(){
		if(! $(this).is('.fg-button-toggleable, .fg-buttonset-single .fg-button,  .fg-buttonset-multi .fg-button') ){
			$(this).removeClass("ui-state-active");
		}
	});
});

function ShowHideTopBar() {
	$('#TopControlDiv').slideToggle('slow', function() {
		$('#SlideToggle').toggleClass('ui-icon-triangle-1-s');
	});
}

function ResetView() {
	$("#WelcomeDiv").hide();
	$("#FactoryMainDiv").hide();	
}

function InitCrud(){
	FactoryObj = new RapidCrud();	
	FactoryObj.GetMainTabMetaData();
}

function InitWorkflow(){
	FactoryObj = new RapidWorkflow();
	InitFactoryTab();
}

function InitCms(){
	FactoryObj = new RapidCms();
	InitFactoryTab();
}

function _MainTabCallBack() {
	FactoryObj.DisplayMainTab();
}

function _SubTabCallBack() {
	FactoryObj.DisplaySubTab();
}

function _TabContentCallBack() {
	FactoryObj.DisplayTabChild();
}