section .data  
	primr: db  "El resultado es %2.0lf",10,0 
section .bss 
	resp: resq 2
section .text 

extern printf
global sum
, main
sum:
 	PUSH rbp 
	MOV rbp, rsp 
	SUB rsp, 48 
	MOV QWORD [rbp -24], rdi 
	MOV rax, QWORD [rbp -24]
	MOV rdi, 6
	ADD rax, rdi

	ADD rsp, 48 
	MOV rsp, rbp 
	POP rbp 
	ret 
	
main:
 	PUSH rbp 
	MOV rbp, rsp 
	SUB rsp, 48 
		MOV WORD [rbp -4] , 2
	MOV WORD [rbp -8] , 0
	MOV rax, QWORD [rbp -4]
	MOV rdi, rax 

	call sum
	MOV QWORD [rbp -8], rax
	
	PUSH qword[rbp -8]
	FILD dword[rsp]
	FSTP qword[rel resp]
	ADD rsp, 8
	MOVSD xmm0,qword[rel resp]
	MOV rdi, primr
	MOV al, 1
	call printf WRT ..plt 
	
	ADD rsp, 48 
	MOV rsp, rbp 
	MOV rax, 60 
	MOV rdi, 0 
	syscall 
	