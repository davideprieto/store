# store
Accenture test

API que realiza la creación, actualización y eliminación de un pedido.
sotore-api server escucha en el puerto 8000

#Uso de la API

El servicio usa datos Json para todas las peticiones y respuestas 

Petición: Get/products

trae la coleccion de productos, los cuales son quemados en el codigo en la clase StoreRepository, dando como respuesta

Respuesta

[
    {
        "name": "Jabón",
        "description": "Jabón de manos",
        "price": 500,
        "amount": 0
    },
    {
        "name": "crema",
        "description": "crema de dientes",
        "price": 200,
        "amount": 0
    },
    {
        "name": "Shampoo",
        "description": "Sahmpoo rizos",
        "price": 700,
        "amount": 0
    },
    {
        "name": "Cepillo",
        "description": "Cepillo duro",
        "price": 100,
        "amount": 0
    },
    {
        "name": "Estropajo",
        "description": "Estropajo natural",
        "price": 300,
        "amount": 0
    }
]

Petición: Post/order

Crear la orden 
parametros {

idCustomer: 12345
address: carrera 11 #23 14-08

en el cuerpo se le cambia el valor de la cantidad ya que al momento de obtenerlos son iniciados con cantidad cero

Body{


[
    {
        "name": "Jabón",
        "description": "Jabón de manos",
        "price": 5000,
        "amount": 6
    },
    {
        "name": "crema",
        "description": "crema de dientes",
        "price": 2000,
        "amount": 10
    },
    {
        "name": "Shampoo",
        "description": "Sahmpoo rizos",
        "price": 7000,
        "amount": 1
    },
    {
        "name": "Cepillo",
        "description": "Cepillo duro",
        "price": 1000,
        "amount": 2
    },
    {
        "name": "Estropajo",
        "description": "Estropajo natural",
        "price": 3000,
        "amount": 5
    }
]
}

Respuesta

{
    "products": [
        {
            "name": "Jabón",
            "description": "Jabón de manos",
            "price": 5000,
            "amount": 6
        },
        {
            "name": "crema",
            "description": "crema de dientes",
            "price": 2000,
            "amount": 10
        },
        {
            "name": "Shampoo",
            "description": "Sahmpoo rizos",
            "price": 7000,
            "amount": 1
        },
        {
            "name": "Cepillo",
            "description": "Cepillo duro",
            "price": 1000,
            "amount": 2
        },
        {
            "name": "Estropajo",
            "description": "Estropajo natural",
            "price": 3000,
            "amount": 5
        }
    ],
    "id": "1e12741f-5d8b-483d-b565-3fe75689adb8",
    "totalPrice": 89560.0,
    "dateOrder": "2021-04-22T16:09:02.324+00:00",
    "idCustomer": 12346,
    "address": "carrera 11 #23 14-08",
    "tax": "19%",
    "deliveryCost": 1500,
    "status": "Aprobado"
}

Petición: Get/order
Muestra todas las ordenes creadas en la peticion anterior con sus  respectivos productos.

Respuesta{
[
    {
        "products": [
            {
                "name": "Jabón",
                "description": "Jabón de manos",
                "price": 5000,
                "amount": 6
            },
            {
                "name": "crema",
                "description": "crema de dientes",
                "price": 2000,
                "amount": 10
            },
            {
                "name": "Shampoo",
                "description": "Sahmpoo rizos",
                "price": 7000,
                "amount": 1
            },
            {
                "name": "Cepillo",
                "description": "Cepillo duro",
                "price": 1000,
                "amount": 2
            },
            {
                "name": "Estropajo",
                "description": "Estropajo natural",
                "price": 3000,
                "amount": 5
            }
        ],
        "id": "1e12741f-5d8b-483d-b565-3fe75689adb8",
        "totalPrice": 89560.0,
        "dateOrder": "2021-04-22T16:09:02.324+00:00",
        "idCustomer": 12346,
        "address": "carrera 11 #23 14-08",
        "tax": "19%",
        "deliveryCost": 1500,
        "status": "Aprobado"
    },
    {
        "products": [
            {
                "name": "Jabón",
                "description": "Jabón de manos",
                "price": 5000,
                "amount": 9
            },
            {
                "name": "crema",
                "description": "crema de dientes",
                "price": 2000,
                "amount": 10
            },
            {
                "name": "Shampoo",
                "description": "Sahmpoo rizos",
                "price": 7000,
                "amount": 1
            },
            {
                "name": "Cepillo",
                "description": "Cepillo duro",
                "price": 1000,
                "amount": 2
            },
            {
                "name": "Estropajo",
                "description": "Estropajo natural",
                "price": 3000,
                "amount": 5
            }
        ],
        "id": "cd83f715-d002-4f2a-9fb3-3a004d3b3031",
        "totalPrice": 107410.0,
        "dateOrder": "2021-04-22T16:17:49.355+00:00",
        "idCustomer": 12345,
        "address": "carrera 11 #23 14-08",
        "tax": "19%",
        "deliveryCost": 1500,
        "status": "Aprobado"
    }
]

Petición: Put/order
Se realiza la actualización respectiva con dependiendo de las logica del negocio, se realiza la busqueda de la orden por el id generado en la creación de la orden.

Body{
{
    "products": [
        {
            "name": "Jabón nuevo ",
            "description": "Jabón de manos",
            "price": 15000,
            "amount": 6
        }
    ],
        "id": "1e12741f-5d8b-483d-b565-3fe75689adb8",
        "totalPrice": 89560.0,
        "dateOrder": "2021-04-22T16:09:02.324+00:00",
        "idCustomer": 12346,
        "address": "carrera 11 #23 14-08",
        "tax": "19%",
        "deliveryCost": 1500,
        "status": "Aprobado"
    }
}

Respuesta 

[
    {
        "products": [
            {
                "name": "Jabón nuevo ",
                "description": "Jabón de manos",
                "price": 15000,
                "amount": 6
            }
        ],
        "id": "1e12741f-5d8b-483d-b565-3fe75689adb8",
        "totalPrice": 107100.0,
        "dateOrder": "2021-04-22T16:20:30.083+00:00",
        "idCustomer": 12346,
        "address": "carrera 11 #23 14-08",
        "tax": "19%",
        "deliveryCost": 0,
        "status": "Aprobado"
    },

Petición: Delete/order
En esta peticion se realiza la eliminación de una orden con el id de la orden previamente creada, realizando un cambio de estado en la orden de aprobada a cancelada

parametros de entrada{
id: cd83f715-d002-4f2a-9fb3-3a004d3b3031
}

respuesta{
  "id": "cd83f715-d002-4f2a-9fb3-3a004d3b3031",
        "totalPrice": 0.0,
        "dateOrder": "2021-04-22T16:17:49.355+00:00",
        "idCustomer": 12345,
        "address": "carrera 11 #23 14-08",
        "tax": "0",
        "deliveryCost": 0,
        "status": "Cancelado"
    }
]
}
