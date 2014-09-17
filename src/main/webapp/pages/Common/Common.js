Application.$controller("CommonPageController", ['$scope',
    function ($scope) {
        "use strict";

        /* perform any action with the variables inside this block(on-page-load) */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through $scope.Variables property here
             * e.g. $scope.Variables.staticVariable1.getData()
             */
        };
        /* perform any action with widgets inside this block */
        $scope.onPageReady = function () {
            /*
             * widgets can be accessed through '$scope.Widgets' property here
             * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
             */
        };

    }
    ]);

Application.$controller("CommonLoginDialogController", ["$scope", "DialogService",
    function ($scope, DialogService) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.CommonLoginDialogError = function ($event, $isolateScope) {
            /*
             * Error message can be accessed from the property $isolateScope.loginMessage.caption
             */
        };

        $scope.CommonLoginDialogSuccess = function ($event, $isolateScope) {
            DialogService.hideDialog("CommonLoginDialog");
        };
    }
    ]);