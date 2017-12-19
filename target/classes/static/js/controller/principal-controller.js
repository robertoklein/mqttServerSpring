appCliente.controller("principalController", function($scope,$http,$location,$stomp){

	$scope.listaDataMqtt = [];

	$scope.listaDados = function(){
		$http.get("/listaDados").then(function(response){
			$scope.listaDataMqtt = response.data;
			
			for(i = 0; i < $scope.listaDataMqtt.length; i++){
				console.log("valor da data: " + $scope.listaDataMqtt[i].date.dayOfMonth);
			}
			
			
		} , function(response){
			console.log("falha " + response);
		});
	}	

	$scope.listaDados();

	$scope.connect = function() {
		$stomp.connect('/endpoint',{})
		.then(function (frame){
			var subscription = $stomp.subscribe('/topic/notify', function(payload, headers, res){
				console.log("result do res: " + res.body);
				$scope.listaDataMqtt.push(JSON.parse(res.body));	
				$scope.$apply();
			}, {
				'headers' : 'so o header'
			});
		});
	}
	$scope.connect();
	
	$scope.formata = function(mqttData){
		
		
	}

	/*
	function setConnected(connected) {
		if (connected) {
			stompClient.subscribe('/topic/notify', function (response) {
				console.log("entrou log do setConected: " + response);
				$scope.listaDataMqtt.push(JSON.parse(response.body));
				$scope.$apply();
			});
		}
		else {
			console.log("nao esta conectado!!!");
		}
	}
	var stompClient = null;

	$scope.connect = function() {
		var socket = new SockJS('/endpoint');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function (frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
		});
	}

	$scope.connect();

	$scope.envia = function(){
		stompClient.send("/app/notify");
		//stompClient.send("/topic/notify");
	}
	 */

});
