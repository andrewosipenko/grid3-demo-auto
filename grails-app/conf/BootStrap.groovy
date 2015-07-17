import grid3.demo.auto.Brand
import grid3.demo.auto.Car
import grid3.demo.auto.CarModel
import grid3.demo.auto.Engine
import grid3.demo.auto.Transmission

class BootStrap {
    private Brand brand

    def init = { servletContext ->
        try {
            createFordDemoData()
//            getOrSaveBrand(brandId: 'Mercedes', name: 'Mercedes Benz')
//
//            getOrSaveBrand(brandId: 'VW', name: 'Volkswagen')
//
//            getOrSaveBrand(brandId: 'Volvo')

        }
        finally {
            brand = null
        }
    }
    def destroy = {
    }

    private void createFordDemoData(){
        brand = getOrSave('brandId', new Brand(brandId: 'Ford'))

        CarModel model = getOrSave('modelId', new CarModel(modelId: 'Focus'))

        Engine engine10d = getOrSave('engineId', new Engine(engineId: '1.0 Diesel'))
        Engine engine12d = getOrSave('engineId', new Engine(engineId: '1.2 Diesel'))
        Engine engine14d = getOrSave('engineId', new Engine(engineId: '1.4 Diesel'))
        Engine engine16d = getOrSave('engineId', new Engine(engineId: '1.6 Diesel'))
        Engine engine18d = getOrSave('engineId', new Engine(engineId: '1.8 Diesel'))
        Engine engine20d = getOrSave('engineId', new Engine(engineId: '2.0 Diesel'))

        Engine engine10p = getOrSave('engineId', new Engine(engineId: '1.0 Petrol'))
        Engine engine12p = getOrSave('engineId', new Engine(engineId: '1.2 Petrol'))
        Engine engine14p = getOrSave('engineId', new Engine(engineId: '1.4 Petrol'))
        Engine engine16p = getOrSave('engineId', new Engine(engineId: '1.6 Petrol'))
        Engine engine18p = getOrSave('engineId', new Engine(engineId: '1.8 Petrol'))
        Engine engine20p = getOrSave('engineId', new Engine(engineId: '2.0 Petrol'))

        Transmission transmission5m = getOrSave('transmissionId', new Transmission(transmissionId: '5 manual'))
        Transmission transmission6m = getOrSave('transmissionId', new Transmission(transmissionId: '6 manual'))
        Transmission transmission5a = getOrSave('transmissionId', new Transmission(transmissionId: '5 automat'))
        Transmission transmission6a = getOrSave('transmissionId', new Transmission(transmissionId: '6 automat'))

        Car car = getOrSave('carId', new Car(carId: '0001', model: model, engine: engine10d, transmission: transmission5m))
        car = getOrSave('carId', new Car(carId: '0002', model: model, engine: engine12d, transmission: transmission5m))
        car = getOrSave('carId', new Car(carId: '0003', model: model, engine: engine14d, transmission: transmission5m))

        car = getOrSave('carId', new Car(carId: '0004', model: model, engine: engine10d, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '0005', model: model, engine: engine12d, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '0006', model: model, engine: engine14d, transmission: transmission6m))

        car = getOrSave('carId', new Car(carId: '0007', model: model, engine: engine10d, transmission: transmission5a))
        car = getOrSave('carId', new Car(carId: '0008', model: model, engine: engine12d, transmission: transmission5a))

        car = getOrSave('carId', new Car(carId: '000A', model: model, engine: engine10d, transmission: transmission6a))
        car = getOrSave('carId', new Car(carId: '000B', model: model, engine: engine12d, transmission: transmission6a))

        model = getOrSave('modelId', new CarModel(modelId: 'Fiesta'))
        car = getOrSave('carId', new Car(carId: '0011', model: model, engine: engine12d, transmission: transmission5m))
        car = getOrSave('carId', new Car(carId: '0012', model: model, engine: engine14d, transmission: transmission5m))
        car = getOrSave('carId', new Car(carId: '0013', model: model, engine: engine16d, transmission: transmission5m))
        car = getOrSave('carId', new Car(carId: '0014', model: model, engine: engine18d, transmission: transmission5m))
        car = getOrSave('carId', new Car(carId: '0015', model: model, engine: engine20d, transmission: transmission5m))

        car = getOrSave('carId', new Car(carId: '0016', model: model, engine: engine10p, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '0017', model: model, engine: engine12p, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '0018', model: model, engine: engine14p, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '0019', model: model, engine: engine16p, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '001A', model: model, engine: engine18p, transmission: transmission6m))
        car = getOrSave('carId', new Car(carId: '001B', model: model, engine: engine20p, transmission: transmission6m))

        car = getOrSave('carId', new Car(carId: '001C', model: model, engine: engine10d, transmission: transmission5a))
        car = getOrSave('carId', new Car(carId: '001D', model: model, engine: engine12d, transmission: transmission5a))

        car = getOrSave('carId', new Car(carId: '001E', model: model, engine: engine18p, transmission: transmission6a))
        car = getOrSave('carId', new Car(carId: '001F', model: model, engine: engine20p, transmission: transmission6a))

    }

    private void createHondaDemoData(){
        Brand brand = getOrSave('brandId', new Brand(brandId: 'Honda'))

        CarModel model = getOrSave('modelId', new CarModel(modelId: 'Civic'))
    }

    private Object getOrSave(String property, Object object){
        println "getOrSave: ${property} ${object}"
        Object res = object.class.createCriteria().get{
            if(brand){
                eq('brand', brand)
            }
            eq(property, object[property])
        }
        if(!res){
            if(object.hasProperty('brand')) {
                object.brand = brand
            }
            res = object.save(failOnError:true)
        }
        return res
    }

}
