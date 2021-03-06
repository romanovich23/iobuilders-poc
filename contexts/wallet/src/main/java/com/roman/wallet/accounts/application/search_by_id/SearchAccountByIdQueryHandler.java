package com.roman.wallet.accounts.application.search_by_id;

import com.roman.shared.domain.bus.query.QueryHandler;
import com.roman.wallet.accounts.application.AccountResponse;
import com.roman.wallet.accounts.domain.Account;
import com.roman.wallet.accounts.domain.AccountNotFoundError;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class SearchAccountByIdQueryHandler implements QueryHandler<SearchAccountByIdQuery, AccountResponse> {
    private final AccountFinderById finder;

    public SearchAccountByIdQueryHandler(AccountFinderById finder) {
        this.finder = finder;
    }

    @Override
    public AccountResponse handle(SearchAccountByIdQuery query) {
        Optional<Account> optional = finder.find(query.id());
        if (optional.isPresent()) {
            Account account = optional.get();
            return new AccountResponse(account.id().value(), account.userId().value(), account.balance().value());
        }
        throw new AccountNotFoundError(String.format("The account with Id <%s> not exists", query.id()));
    }
}
