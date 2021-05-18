// @ts-nocheck
sap.ui.define([
    "sap/ui/core/mvc/Controller",
], function (Controller) {
    "use restrict";
    let attModel;
    return Controller.extend("sap.ui.demo.wt.controller.Vista1",{

        onInit: function (){
            that = this;
            jQuery.ajax({
                type: "GET",
                contentType: "application/json",
                url: "http://localhost:8080/CustomerService/rest/customer",
                dataType: "json",
                async: false,
                success: function(data, textStatus, jqXHR) {
                    let oModel = new sap.ui.model.json.JSONModel();
                    oModel.setData(data);
                    that.getView().setModel(oModel, "customer");
                    sap.ui.getCore().setModel(oModel);
                }
            });
        },

        onAfterRendering:function (){
            that = this;
            jQuery.ajax({
                type: "GET",
                contentType: "application/json",
                url: "http://localhost:8080/CustomerService/rest/customer",
                dataType: "json",
                async: false,
                success: function(data, textStatus, jqXHR) {
                    let oModel = new sap.ui.model.json.JSONModel();
                    oModel.setData(data);
                    that.getView().setModel(oModel, "customer");
                    sap.ui.getCore().setModel(oModel);
                }
            });
        },

        gotoAgregar:function(){
            var oapp=sap.ui.getCore().byId("app");
            oapp.to(pageAgregar);
        },
        onSelectionChange:function (oEvent){
         /*   var oSelectedItem = oEvent.getParameter("listItem");
            var oModel = oSelectedItem.getBindingContext("customer").getObject();
            alert(JSON.stringify(oModel));*/

            var oApp=sap.ui.getCore().byId("app");
            oApp.to(pageDetalle);

            var oPage=oApp.getPage("idMyViewDetalle");
            var oContext=oEvent.getParameter("listItem").getBindingContext("customer");
            oPage.setBindingContext(oContext);
        }

    });
});
