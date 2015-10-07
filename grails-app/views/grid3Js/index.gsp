<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Cars</title>
  <meta name="layout" content="main"/>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <g:javascript src="jquery.grid3table.js" />
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'grid3table.css')}" type="text/css">
</head>
<body>
  <h1>Cars</h1>
  <div id="cars" data-query='
<hqlXml>
  <columns>
    <column path="brand.brandId"/>
    <column path="model.modelId"/>
    <column path="car.carId" editable="value" />
    <column path="engine.engineId" editable="reference">
      <options>
        <hqlXml>
          <columns>
            <column path="engineOption.id" target="row.engine.id"/>
            <column path="engineOption.engineId" target="row.engine.engineId"/>
          </columns>
          <table domain="Engine" alias="engineOption" key="id"/>
        </hqlXml>
      </options>
    </column>
    <column path="transmission.transmissionId" editable="value" />
  </columns>
  <table domain="Car" alias="car" key="id"/>
  <leftJoin path="car.model">
    <table domain="CarModel" alias="model" key="id" />
  </leftJoin>
  <leftJoin path="model.brand">
    <table domain="Brand" alias="brand" key="id" />
  </leftJoin>
  <leftJoin path="car.engine">
    <table domain="Engine" alias="engine" key="id" />
  </leftJoin>
  <leftJoin path="car.transmission">
    <table domain="Transmission" alias="transmission" key="id" />
  </leftJoin>
</hqlXml>' data-url="${resource(file: 'grid3')}"></div>
  <g:javascript>
    $('#cars').grid3table();
  </g:javascript>
</body>
</html>