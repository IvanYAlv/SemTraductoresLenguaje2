# SemTraductoresLenguaje2
Tareas de SEMINARIO DE SOLUCION DE PROBLEMAS DE TRADUCTORES DE LENGUAJES II.

Actualización del analizador léxico-sintáctico-semántico (05/12/2022).

Video ejecutando la fase final del proyecto: https://drive.google.com/file/d/1v6yHwBrMx31ZZI0p1Z3fO0iVbJwY8s8G/view?usp=sharing

NOTA: el comando "sudo apt-get install nasm" también es necesario, olvidé mencionarlo en el veideo.

Se analizaron los dos ejemplos propuestos para la actividad: 

'''Ejemplo 1: '''
'''cad = "int main(){\
\nfloat a;\
\nint b;\
\nint c;\
\nc = a+b;\
\nc = suma(8,9);\
\n}"'''

'''Ejemplo 2: '''
'''cad = "int a;\n\
int suma(int a, int b){\
\nreturn a+b;\
\n}\
\nint main(){\
\nfloat a;\
\nint b;\
\nint c;\
\nc = a+b;\
\nc = suma(8.5,9.9);\
\n}"'''

Resultados: 

![Error_FuncSuma](https://user-images.githubusercontent.com/111928650/201812490-cdfda0dc-b2fa-4dd6-b330-8465c5329824.png)

  Este nos muestra el error al hacer la llamada a la función "suma", la cual no está declarada.
  
![ErrorTipos](https://user-images.githubusercontent.com/111928650/201812648-f0c0c505-69a3-488a-8956-77b89910e5d6.png)

  En este se nos muestra un error por los tipos de datos en los parametros de la función "suma".
  
-------------------------------------------------------------------------------------------------------------------------------

Nota: Por practicidad (generación de código similar en otra asignatura), hubo un cambio de lenguaje, de c++ a python.

.- Mostrar árbol sintactico: 

  Entrada: 
  
  ![image](https://user-images.githubusercontent.com/111928650/197617926-2c76c06c-ef26-4cfb-820e-3d22dd2245ca.png)


![image](https://user-images.githubusercontent.com/111928650/197617652-8c934247-5d2f-42c3-b6ae-717d8f82b9bc.png)

...

![image](https://user-images.githubusercontent.com/111928650/197617777-14333dec-6ee2-439a-a890-703a75ce15c4.png)

.- Tabla de símbolos: 

![image](https://user-images.githubusercontent.com/111928650/197618290-371d8018-76cf-43c1-a141-c4645f0b79e7.png)


Actualización del analizador léxico-sintáctico (18/09/2022).

Ahora se cargó la tabla final que vimos en clase, con el ejemplo propuesto también en clase (int a ; int main ( ) { int b ; }).
Existe un detalle meramente estético, al imprimir algunas salidas, se imprimen otros símbolos que no pertenecen a la cadena. 
Sin embargo, como ya se mencionó, esto no afecta su funcionamiente.
El último detalle es que quedan por agregar las reglas que no se usaron para el ejemplo.

Resultados: 

![image](https://user-images.githubusercontent.com/111928650/190950474-217d4178-40f3-4bef-918d-05d65b7d7aca.png)



Actualización del analizador sintáctico (12/09/2022). 

La pila ahora es una pila de objetos, en la siguiente captura se aprecia que sigue funcionando correctamente:

Actualización de la pila:

![image](https://user-images.githubusercontent.com/111928650/189787353-c5bc14ca-20cf-43de-aa2e-628e186fbdad.png)

Resultados:


  Ejercicio: 
  
  ![image](https://user-images.githubusercontent.com/111928650/189787812-23d4f975-08ae-43a6-8547-3806ebfd101d.png)

  Ejecución del programa:
  
  ![image](https://user-images.githubusercontent.com/111928650/189787982-216e5bc3-ca78-45b7-8869-8e35358d1c39.png)


Capturas del mini analizador sintáctico

NOTA: simplemente se descomenta la tabla y dos funciones correspondientes, dependiendo qué ejercicio se resolverá. Igualmente el algoritmo funciona para ambos casos.

Ejercicio 1:

![CapE1](https://user-images.githubusercontent.com/111928650/187588633-748a351f-b341-47f9-b833-d579f702baf2.png)

Ejercicio 2: 

![CapE2](https://user-images.githubusercontent.com/111928650/187588650-e0800aee-3c4e-442e-ae10-bf232d6cd204.png)

NOTA: Las cadenas se muestran primero porque se analizan antes que el resto.

![image](https://user-images.githubusercontent.com/111928650/186288878-e1410b03-a7ff-4aa3-8e17-96c29b945b7c.png)

