package com.roman.wallet.accounts.domain;

import java.util.Optional;

public interface AccountRepository {
    void save(Account account);
    Optional<Account> findByUserId(String userId);
}
