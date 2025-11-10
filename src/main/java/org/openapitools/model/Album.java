package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Album
 */

@JsonTypeName("album")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
public class Album {

  private @Nullable String id;

  private @Nullable String artistId;

  private @Nullable String title;

  private @Nullable String releaseDate;

  private @Nullable String coverUrl;

  public Album id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", example = "alb_101", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public Album artistId(@Nullable String artistId) {
    this.artistId = artistId;
    return this;
  }

  /**
   * Get artistId
   * @return artistId
   */
  
  @Schema(name = "artist_id", example = "art_001", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("artist_id")
  public @Nullable String getArtistId() {
    return artistId;
  }

  public void setArtistId(@Nullable String artistId) {
    this.artistId = artistId;
  }

  public Album title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", example = "La ley innata", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public Album releaseDate(@Nullable String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * Get releaseDate
   * @return releaseDate
   */
  
  @Schema(name = "release_date", example = "2008-09-09", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("release_date")
  public @Nullable String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(@Nullable String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Album coverUrl(@Nullable String coverUrl) {
    this.coverUrl = coverUrl;
    return this;
  }

  /**
   * Get coverUrl
   * @return coverUrl
   */
  
  @Schema(name = "cover_url", example = "https://avatar.iran.liara.run/public/40", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cover_url")
  public @Nullable String getCoverUrl() {
    return coverUrl;
  }

  public void setCoverUrl(@Nullable String coverUrl) {
    this.coverUrl = coverUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Album album = (Album) o;
    return Objects.equals(this.id, album.id) &&
        Objects.equals(this.artistId, album.artistId) &&
        Objects.equals(this.title, album.title) &&
        Objects.equals(this.releaseDate, album.releaseDate) &&
        Objects.equals(this.coverUrl, album.coverUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, artistId, title, releaseDate, coverUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Album {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    artistId: ").append(toIndentedString(artistId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    coverUrl: ").append(toIndentedString(coverUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

