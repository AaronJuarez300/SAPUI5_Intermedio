sap.ui.define([
    "sap/ui/core/mvc/Controller",
], function (Controller) {
    "use restrict";
    return Controller.extend("controller.Vista1",{

        holaMundo: function () {
            alert("Hola Mundo");
        }

    });
});
