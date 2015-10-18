(function() {

	var app = angular.module('rules', []);

	app.directive('rulesView', function(){
  		// Runs during compile
  		return {
  			// controller: function($scope, $element, $attrs, $transclude) {},
  			restrict: 'E', // E = Element, A = Attribute, C = Class, M = Comment
  			templateUrl: 'views/rules-view.html',
  			controller: function($http){
  				var collection = this;
  				this.cards = [];
  				$http.get('/datas/cards.json').success(function(data){
  					collection.cards = data;
  				});

  				this.getRawMaterials=function(){
  					return this.cards.RawMaterial;
  				};
  				this.getManufacturedGoods=function(){
  					return this.cards.ManufacturedGoods;
  				};
  				this.getCivilianStructures=function(){
  					return this.cards.CivilianStructures;
  				};
  				this.getCommercialStructures=function(){
  					return this.cards.CommercialStructures;
  				};  				
  				this.getScientificStructures=function(){
  					return this.cards.ScientificStructures;
  				};  				
  				this.getMilitaryStructures=function(){
  					return this.cards.MilitaryStructures;
  				};  				
  				this.getGuilds=function(){
  					return this.cards.Guilds;
  				};
  			},
  			controllerAs:"collection"
  		};
  	});


app.controller('CardTypeSwitch', function(){
	this.tab = 1;
	this.selectTab = function(value) {
		this.tab = value;
	};
	this.isSelected = function(value) {
		return this.tab === value;
	};
});


})();