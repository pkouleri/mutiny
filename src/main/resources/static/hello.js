angular.module('mutiny', ['ngStomp'])
    .controller('PostCtrl', function ($scope, $http, $log, $stomp, $route) {
        $stomp
            .connect('/channel')
            .then(function (frame) {
                var subscription = $stomp.subscribe('/topic/posts', function (payload, headers, res) {
                    $scope.payload = payload;
                    console.log("payload is:" + payload);
                    $scope.$apply(function () {
                        $scope.payload = payload;
                    });
                }, {
                    'headers': 'are awesome'
                })
            });

        $http.get('/post/list').then(function (response) {
            $scope.posts = response.data;
        });
    });


//
//angular.module('mutiny', ['ngStomp'])
//    .controller('PostCtrl', function ($stomp, $scope, $http, $log) {
//        $stomp.setDebug(function (args) {
//            $log.debug(args)
//        });
//
//        $stomp.connect('/channel').then(function (frame) {
//            var subscription = $stomp.subscribe('/topic/posts', function (payload, headers, res) {
//                $scope.payload = payload
//            }, {
//                'headers': 'are awesome'
//            });
//
//            // Disconnect
//            $stomp.disconnect().then(function () {
//                $log.info('disconnected')
//            })
//        });
//
//        $http.get('/post/list').then(function (response) {
//            $scope.posts = response.data;
//        });
//    });
