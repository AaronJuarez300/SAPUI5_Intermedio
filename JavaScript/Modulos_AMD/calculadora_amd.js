define(['suma_amd','resta_amd','multiplicacion_amd','division_amd'], function (Suma,Resta,Multiplicacion,Division){
	var Calculadora ={
		suma: function(num1,num2){
			var suma = new Suma(num1, num2);
			return suma.suma;
		},
		
		resta:function(num1,num2){
			var resta = new Resta(num1, num2);
			return resta.resta;
		},
		
		multiplicacion:function(num1,num2){
			var multiplicacion = new Multiplicacion(num1, num2);
			return multiplicacion.multiplicacion;
		},
		
		division:function(num1,num2){
			var division = new Division(num1, num2);
			return division.division;
		}
		
	};
	
	return Calculadora;
});