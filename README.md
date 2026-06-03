# gestion-inventario
SISTEMA DE GESTION DE INVENTARIOS

PLANTEAMIENTO DEL PROBLEMA:

Se requiere un sistema de gestion de inventarios para una tienda en linea que permita a los administradores agregar productos, gestionar stock y procesar pedidos de clientes.

PRODUCTOS:
- Cada producto tiene identificador, nombre, precio y stock.
- Los productos se crean a partir de un prototipo base.

INVENTARIO:
- El catalogo de productos es unico y centralizado.
- El stock se maneja por separado del catalogo de productos.

PEDIDOS:
- Un pedido contiene uno o mas items (producto y cantidad).
- Estados posibles: PENDIENTE, COMPLETA, ANULADA.

STOCK:
- El stock se almacena en memoria.
- Se puede consultar disponibilidad y descontar unidades al vender.

PATRONES IMPLEMENTADOS:
- Singleton: para el gestor de productos (una sola instancia).
- Prototype: para crear nuevos productos a partir de un prototipo base.
- Bridge: para separar la logica de stock de la interfaz de usuario.
- Adapter: para integrar el sistema de inventario con el procesador de pedidos.
