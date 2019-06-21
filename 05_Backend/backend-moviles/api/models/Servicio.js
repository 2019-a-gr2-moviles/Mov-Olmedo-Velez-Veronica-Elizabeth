/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string'
    },
    // CONFIGURACIÓN DEL HIJO
    fkUsuario: { // Nombre del FK para la relación viene del papa
      model: 'usuario'
      //require: true //OPCIONAL//Si el campo es obligatorio
    }

  },

};

