sap.ui.define([
    "sap/ui/core/mvc/Controller",
], function (Controller) {
    "use restrict";
    let attModel;
    return Controller.extend("sap.ui.demo.wt.controller.Vista1",{

        onInit: function (){
            attModel = new sap.ui.model.json.JSONModel();
            attModel.loadData("json/Modelo.json");
            //console.log("Estoy creandome...");
        },
        saludar: function () {
            //console.log(attModel.getData()[0].mensaje);
            //alert("Hola Mundo");
            attModel.getData()[0].mensaje = this.getView().byId('txtSaludo').getValue();
            //console.log(attModel.getData()[0]);
            alert(attModel.getData()[0].mensaje);
        }

    });
});
