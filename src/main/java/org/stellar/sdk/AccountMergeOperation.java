package org.stellar.sdk;

import com.google.gson.annotations.SerializedName;

import org.stellar.base.Keypair;

public class AccountMergeOperation extends Operation {
  @SerializedName("account")
  protected final Keypair account;
  @SerializedName("into")
  protected final Keypair into;

  public AccountMergeOperation(Keypair account, Keypair into) {
    this.account = account;
    this.into = into;
  }

  public Keypair getAccount() {
    return account;
  }

  public Keypair getInto() {
    return into;
  }
}
