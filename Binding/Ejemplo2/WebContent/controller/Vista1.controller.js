sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/ui/core/routing/History",
    "sap/ui/demo/wt/formatters/EmailType",
    "sap/ui/demo/wt/formatters/formatter",
], function (Controller, History,EmailType,formatter) {
    "use restrict";

    return Controller.extend("sap.ui.demo.wt.controller.Vista1",{
        formatter: formatter,
        onInit: function () {
            let oJModCust = new sap.ui.model.json.JSONModel();
            oJModCust.loadData("json/Product.json");
            this.getView().setModel(oJModCust,"products");


           this.getView().byId("txtExtendedPrice").attachValidationSuccess(function(oControlEvent){
                alert("Validacion Exitosa");
            });
            this.getView().byId("txtQuantity2").attachParseError(function(oControlEvent){
                alert("Parse Error occurred - this is no integer");


                //throw new sap.ui.model.ValidateException("Invalid Email!");

            },this);
            this.getView().byId("txtQuantity2").attachValidationError(function(oControlEvent){
                alert ("Validation error occurred - some constraints were violated: " +
                    oControlEvent.getParameters().newValue + " is not between minimum and maximum");


            });


        },
        verModelo:function (){
            console.log(this.getView().getModel("products"));
        },

        toUpperCase: function(sName){
            if (sName!=null) return sName.toUpperCase();
        }

    });
});
