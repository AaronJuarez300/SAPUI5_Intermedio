sap.ui.define([
    "sap/ui/model/SimpleType",
    "sap/ui/model/ValidateException",
    "sap/ui/demo/wt/formatters/EmailType",
], function (SimpleType, ValidateException) {
    "use restrict";
    return SimpleType.extend("sap.ui.demo.wt.formatters.EmailType",{
        formatValue: function (oValue){
            return oValue;
        },
        parseValue: function (oValue){
            return oValue;
        },
        validateValue: function (oValue){
            if (!/\S+@\S+\.\S+/
                .test(oValue)){
                throw new sap.ui.model.ValidateException("Invalid Email!");
            }
        }
    });
});

