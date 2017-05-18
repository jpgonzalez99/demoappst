var express = require("express"),
   app = express(),
   bodyParser  = require("body-parser"),
   methodOverride = require("method-override"),
   _ = require('lodash'),

   // Data
   airports = require('./services/data.airports'),
   airlines = require('./services/data.airlines')
;


app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(methodOverride());

var router = express.Router();
var responseCreatedOK = {'id': '1'};
var responsePingOK = {'status': 'ok'};

app.use(function(req, res, next) {
   res.header("Access-Control-Allow-Origin", "*");
   res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
   next();
});

router.get('/origins', function(req, res) {
   res.send(airports().getOriginAirports());
});

router.get('/destinationsFrom/*', function(req, res) {
   res.send(airports().getDestinationAirports());
});

router.get('/flightsFrom/*', function(req, res) {
   res.send(airlines().getAirlines());
});


app.use(router);

app.listen(3005, function() {
   console.log("Node server running on http://localhost:3005");
});
