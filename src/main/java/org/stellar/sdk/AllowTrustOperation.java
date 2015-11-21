package org.stellar.sdk;

import com.google.gson.annotations.SerializedName;

import org.stellar.base.Asset;
import org.stellar.base.AssetTypeNative;
import org.stellar.base.Keypair;

public class AllowTrustOperation extends Operation {
  @SerializedName("trustor")
  protected final Keypair trustor;
  @SerializedName("trustee")
  protected final Keypair trustee;
  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;
  @SerializedName("authorize")
  protected final boolean authorize;

  AllowTrustOperation(boolean authorize, String assetIssuer, String assetCode, String assetType, Keypair trustee, Keypair trustor) {
    this.authorize = authorize;
    this.assetIssuer = assetIssuer;
    this.assetCode = assetCode;
    this.assetType = assetType;
    this.trustee = trustee;
    this.trustor = trustor;
  }

  public Keypair getTrustor() {
    return trustor;
  }

  public Keypair getTrustee() {
    return trustee;
  }

  public boolean isAuthorize() {
    return authorize;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      Keypair issuer = Keypair.fromAddress(assetIssuer);
      return Asset.createNonNativeAsset(assetCode, issuer);
    }
  }
}
