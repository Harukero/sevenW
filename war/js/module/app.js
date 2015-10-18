(function() {
  var app = angular.module('sevenWonders', ["rules"]);

  app.directive('gameView', function(){
  	// Runs during compile
  	return {
  		// controller: function($scope, $element, $attrs, $transclude) {},
  		restrict: 'E', // E = Element, A = Attribute, C = Class, M = Comment
  		templateUrl: 'views/game-view.html'
  	};
  });

  app.directive('rootPanel', function(){
      // Runs during compile
      return {
        // controller: function($scope, $element, $attrs, $transclude) {},
        restrict: 'E', // E = Element, A = Attribute, C = Class, M = Comment
        templateUrl: 'views/root-panel.html',
        controller: function() {
          this.tab = 1;
          this.selectTab = function(value) {
            this.tab = value;
          };
          this.isSelected = function(value) {
            return this.tab === value;
          };
        },
        controllerAs: "headerCtrl"
      };
    });

})();