sap.ui.define([
    "sap/ui/core/mvc/Controller",
], function (Controller) {
    "use restrict";
    let attModel;
    return Controller.extend("sap.ui.demo.wt.controller.Vista1",{

        onInit: function (){

        },
        gotoPagina2: function () {

            let oapp=sap.ui.getCore().byId("app");
            // @ts-ignore
            oapp.to(page2);
        }

    });
});
