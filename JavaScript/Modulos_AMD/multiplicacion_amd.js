define ([], function() {
	console.log('Cargando Multiplicacion...');
	
	var Multiplicacion = function(num1, num2){
		
		this.multiplicacion = num1 * num2;
		
	}
	return Multiplicacion;
});