package com.example.almacenfastsecurity.data.api

import com.example.almacenfastsecurity.domain.entity.CategoriaProducto
import com.example.almacenfastsecurity.domain.entity.Empleado
import com.example.almacenfastsecurity.domain.entity.GuiaRecepcion
import com.example.almacenfastsecurity.domain.entity.Marca
import com.example.almacenfastsecurity.domain.entity.Producto
import com.example.almacenfastsecurity.domain.entity.Proveedor
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiServices {
    //  *********** GuiasRecepcion     **************
    //listar
    @GET("api/GuiaRecepcionApi/GetGuiasRecepcion")
    suspend fun getGuiasRecepcion() : List<GuiaRecepcion>


    //  *********** GuiasRecepcion     **************
    @GET("api/ProductoApi/GetProductos")
    suspend fun getProductos() : List<Producto>

    @GET("api/ProductoApi/CategoriaProducto")
    suspend fun getCategorias() : List<CategoriaProducto>

    @GET("api/ProductoApi/GetMarcas")
    suspend fun getMarcas() : List<Marca>

    @GET("api/ProductoApi/GetProductoxId")
    suspend fun getProductoById(
        @Query("idProducto") idProducto : Int
    ) : Producto

    @POST("api/ProductoApi/AgregarProducto")
    suspend fun saveProducto(@Body producto : Producto) :String

    @PUT("api/ProductoApi/ActualizarProducto")
    suspend fun updateProducto(@Body producto : Producto) :String

    @DELETE("api/ProductoApi/EliminarProducto")
    suspend fun deleteProducto(
        @Query("id") idProducto : Int
    ) : String

    @GET("api/ProductoApi/GetMarcaxId")
    suspend fun getMarcaById(
        @Query("idMarca") idMarca : Int
    ) : Marca

    @GET("api/ProductoApi/GetCategoriaxId")
    suspend fun getCategoriaById(
        @Query("idCategoria") idCategoria : Int
    ) : CategoriaProducto


    //  *********** PROVEDDOR  **************
    //LISTAR
    @GET("api/ProveedorApi/GetProveedores")
    suspend fun getProveedores() : List<Proveedor>

    //AGREGAR   /api/ProveedorApi/AgregarProveedor
    @POST("api/ProveedorApi/AgregarProveedor")
    //@Body Un cuerpo(entidad)            nos devuelve un String
    suspend fun saveProveedor(@Body proveedor: Proveedor) : String

    //ACTUALIZAR   /api/ProveedorApi/ActualizarProveedor
    @PUT("api/ProveedorApi/ActualizarProveedor")
    //@Body (entidad)            nos devuelve un String
    suspend fun updateProveedor(@Body proveedor: Proveedor) : String

    //ELIMINAR    /api/ProveedorApi/EliminarProveedor
    @DELETE("api/ProveedorApi/EliminarProveedor")
    suspend fun deleteProveedor(
         @Query("idProveedor") idProveedor: Int) : String


    //  *********** EMPLEADO   **************
    @GET("api/EmpleadoApi/GetEmpleados")
    suspend fun getEmpleados() : List<Empleado>




}