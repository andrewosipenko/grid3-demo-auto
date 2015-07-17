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
    <column path="car.carId"/>
  </columns>
  <table domain="Car" alias="car" key="key"/>
</hqlXml>
        """)
        Grid3View grid3View = simpleGrid3ViewService.buildView(grid3)
        render view: '/grid3Demo/index', model: [grid3View: grid3View]
    }
}
