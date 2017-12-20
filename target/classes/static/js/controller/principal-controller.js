appCliente.controller("principalController", function($scope,$http,$location,$stomp){

	$scope.listaDataMqtt = [];

	/**
	 * funcao para listar os dados de temperatura coletados pelo sensor
	 */
	$scope.listaDados = function(){
		$http.get("/listaDados").then(function(response){
			$scope.listaDataMqtt = response.data;
		} , function(response){
			console.log("falha " + response);
		});
	}	

	$scope.listaDados();

	/**
	 * funcao para conectar com o websocker, e setar os listners nos topicos
	 */
	$scope.connect = function() {
		$stomp.connect('/endpoint',{})
		.then(function (frame){
			var subscription = $stomp.subscribe('/topic/notify', function(payload, headers, res){
				$scope.listaDataMqtt.push(JSON.parse(res.body));	
				$scope.$apply();
			}, {
				'headers' : 'so o header'
			});
		});
	}
	$scope.connect();
	
	/**
	 * funcao para ligar o led
	 */
	$scope.ligaLed = function(){
		$http.get("/ligaLed").then(function(response){
			console.log("ligou o led");
		} , function(response){
			console.log("falha ao ligar o led " + response);
		});
	}	
	
	/**
	 * funcao para desligar o led
	 */
	$scope.desligaLed = function(){
		$http.get("/desligaLed").then(function(response){
			console.log("desligou o led");
		} , function(response){
			console.log("falha ao desligar o led " + response);
		});
	}
	
});
