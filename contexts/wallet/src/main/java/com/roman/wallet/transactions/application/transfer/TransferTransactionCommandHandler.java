package com.roman.wallet.transactions.application.transfer;

import com.roman.shared.domain.bus.command.CommandHandler;
import com.roman.shared.domain.bus.command.CommandHandlerExecutionError;
import com.roman.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.stereotype.Service;

@Service
public final class TransferTransactionCommandHandler implements CommandHandler<TransferTransactionCommand> {
    private final TransactionTransfer transfer;

    public TransferTransactionCommandHandler(TransactionTransfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public void handle(TransferTransactionCommand command) throws QueryHandlerExecutionError, CommandHandlerExecutionError {
        transfer.transfer(command.id(), command.userId(), command.destination(), command.quantity(), command.concept());
    }
}
