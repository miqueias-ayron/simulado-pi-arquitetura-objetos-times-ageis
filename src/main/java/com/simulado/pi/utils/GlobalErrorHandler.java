package com.simulado.pi.utils;

import com.simulado.pi.cliente.ClienteNaoEncontradoException;
import com.simulado.pi.equipamento.EquipamentoIndisponivelException;
import com.simulado.pi.equipamento.EquipamentoNaoEncontradoException;
import com.simulado.pi.locacao.LocacaoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(CampoInvalidoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleCampoInvalido(CampoInvalidoException e) {
        return build(e.getMessage(), 400);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleCampoInvalido(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(f -> f.getField() + " é obrigatório")
                .orElse("Campo inválido");
        return build(message, 400);
    }

    @ExceptionHandler({
            ClienteNaoEncontradoException.class,
            EquipamentoNaoEncontradoException.class,
            LocacaoNaoEncontradoException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNaoEncontrado(RuntimeException e) {
        return build(e.getMessage(), 404);
    }

    @ExceptionHandler({EquipamentoIndisponivelException.class, RegistroDuplicadoException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDTO handleIndisponivel(RuntimeException e) {
        return build(e.getMessage(), 409);
    }

    private ErrorResponseDTO build(String message, int statusCode) {
        ErrorResponseDTO dto = new ErrorResponseDTO();
        dto.setMessage(message);
        dto.setStatusCode(statusCode);
        dto.setDate(LocalDateTime.now());
        return dto;
    }
}
