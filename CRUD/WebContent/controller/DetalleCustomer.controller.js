// @ts-nocheck
sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/m/MessageBox",
    "sap/m/MessageToast"
], function (Controller, MessageBox, MessageToast) {
    "use restrict";
    let attModel;
    return Controller.extend("sap.ui.demo.wt.controller.DetalleCustomer",{

        onInit: function (){

        },

        saveCustomer:function (){
            let id = this.getView().byId("txtId").getValue();
            let birthDate = this.getView().byId("txtBirthdate").getValue();
            let name = this.getView().byId("txtNombre").getValue();
            let lastname = this.getView().byId("txtApellido").getValue();
            let email = this.getView().byId("txtEmail").getValue();
            let genero  = this.getView().byId('txtGenero').getSelectedKey();
            let url = 'http://localhost:8080/CustomerService/rest/customer/'+id+ '/'+name+'/'+lastname+'/'+email+'/'+birthDate+'/'+genero
            that = this;
            jQuery.ajax({
                type: "PUT",
                contentType: "application/json",
                url: url,
                dataType: "json",
                async: false,
                success: function(data, textStatus, jqXHR) {
                    MessageToast.show('Cliente modificado correctamente', {
                        duration: 3000,
                        width: "15rem", // default max width supported
                    });
                    that.limpiarCampos();

                },
                error: function (error){
                    MessageBox.error("Error",{
                        title: "Ocurrio un error",
                        details: error.statusText,
                        actions: [MessageBox.Action.OK, MessageBox.Action.CANCEL],
                        emphasizedAction: MessageBox.Action.OK,
                        onClose: function (sAction) { MessageToast.show("Se ha cerrado el messageBox con la opcion: " + sAction) }

                    });
                }
            });
        },

        deleteCustomer:function (){
            let id = this.getView().byId("txtId").getValue();
            let birthDate = this.getView().byId("txtBirthdate").getValue();
            let name = this.getView().byId("txtNombre").getValue();
            let lastname = this.getView().byId("txtApellido").getValue();
            let email = this.getView().byId("txtEmail").getValue();
            let genero  = this.getView().byId('txtGenero').getSelectedKey();
            let url = 'http://localhost:8080/CustomerService/rest/customer/'+id+ '/'+name+'/'+lastname+'/'+email+'/'+birthDate+'/'+genero
            that = this;
            jQuery.ajax({
                type: "DELETE",
                contentType: "application/json",
                url: url,
                dataType: "json",
                async: false,
                success: function(data, textStatus, jqXHR) {
                    MessageToast.show('Cliente eliminado correctamente', {
                        duration: 3000,
                        width: "15rem", // default max width supported
                    });
                    that.limpiarCampos();

                },
                error: function (error){
                    MessageBox.error("Error",{
                        title: "Ocurrio un error",
                        details: error.statusText,
                        actions: [MessageBox.Action.OK, MessageBox.Action.CANCEL],
                        emphasizedAction: MessageBox.Action.OK,
                        onClose: function (sAction) { MessageToast.show("Se ha cerrado el messageBox con la opcion: " + sAction) }

                    });
                }
            });
        },

        limpiarCampos:function (){
            this.getView().byId("txtBirthdate").setValue("");
            this.getView().byId("txtNombre").setValue("");
            this.getView().byId("txtApellido").setValue("");
            this.getView().byId("txtEmail").setValue("");
        },

        gotoPage:function (){
            var oapp=sap.ui.getCore().byId("app");
            oapp.to(page);
            var oPage=oapp.getPage("idMyView1");
            oPage.onAfterRendering();
        }

    });
});
