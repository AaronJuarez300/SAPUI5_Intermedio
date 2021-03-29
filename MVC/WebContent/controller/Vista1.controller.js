sap.ui.define([
    "sap/ui/core/mvc/Controller",
], function (Controller) {
    "use restrict";
    return Controller.extend("sap.ui.demo.wt.controller.Vista1",{

        holaMundo: function () {
            alert("Hola Mundo");
        }

    });
});
