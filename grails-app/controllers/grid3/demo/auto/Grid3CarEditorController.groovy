package grid3.demo.auto

import com.osipenko.grid3.build.hql.HqlGrid3Service
import com.osipenko.grid3.model.Grid3
import com.osipenko.grid3.view.Grid3View

/**
 * Created by osa on 7/17/2015.
 */
class Grid3CarEditorController {
    def hqlGrid3Service
    def simpleGrid3ViewService
    def index(){
        Grid3 grid3 = hqlGrid3Service.buildGrid3("""
<hqlXml>
  <columns>
    <column path="brand.brandId"/>
    <column path="model.modelId"/>
    <column path="car.carId"/>
    <column path="engine.engineId"/>
    <column path="transmission.transmissionId"/>
  </columns>
  <table domain="Car" alias="car" key="key"/>
  <leftJoin path="car.model">
    <table domain="CarModel" alias="model" key="key" />
  </leftJoin>
  <leftJoin path="model.brand">
    <table domain="Brand" alias="brand" key="key" />
  </leftJoin>
  <leftJoin path="car.engine">
    <table domain="Engine" alias="engine" key="key" />
  </leftJoin>
  <leftJoin path="car.transmission">
    <table domain="Tranmission" alias="transmission" key="key" />
  </leftJoin>
</hqlXml>
        """)
        Grid3View grid3View = simpleGrid3ViewService.buildView(grid3)
        render view: '/grid3Demo/index', model: [grid3View: grid3View]
    }
}
