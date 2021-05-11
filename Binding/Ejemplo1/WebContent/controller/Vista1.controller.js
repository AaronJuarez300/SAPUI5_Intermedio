sap.ui.define([
    "sap/ui/core/mvc/Controller",
], function (Controller) {
    "use restrict";

    return Controller.extend("sap.ui.demo.wt.controller.Vista1",{

        onInit: function (){
            let attModel = new sap.ui.model.json.JSONModel();
            attModel.loadData("json/ModeloProductos.json");
            sap.ui.getCore().setModel(attModel,"productos");

        },

        verModelo: function (){
            let attmodel = sap.ui.getCore().getModel("productos");
            console.log(attmodel.getData());

        }
    });
});
