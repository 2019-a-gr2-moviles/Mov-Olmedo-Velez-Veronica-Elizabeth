/**
 *Producto.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    marca: {
      type: 'string',
      required: true,
    },
    color: {
      type: 'string',
      required: true,
    },
    existencias: {
      type: 'number',
      required: true,
      min: 0,
    },
    tipo: {
      type: 'string',
      required: true,
    },
    cantidad: {
      type: 'number',
      required: true,
      min: 0,
    },
    precio: {
      type: 'number',
      required: true,
      min: 0,
    },
    compraDeProducto: {     // Nombre atributo de la relación
      collection: 'compra', // Nombre del modelo a relacionar
      via: 'codigoPro'        // Nombre del campo a hacer la relacion
    },
  },
}