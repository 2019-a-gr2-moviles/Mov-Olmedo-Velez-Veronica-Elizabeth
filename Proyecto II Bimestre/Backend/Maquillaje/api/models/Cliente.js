/**
 * Cliente.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre: {
      type: 'string',
      required: true,
    },
    cedula: {
      type: 'string',
      required: true,
      unique: true,
    },
    apellido: {
      type: 'string',
      required: true,

    },
    compraDeCliente: {     // Nombre atributo de la relación
      collection: 'compra', // Nombre del modelo a relacionar
      via: 'codigoCli'        // Nombre del campo a hacer la relacion
    },
  },
};

