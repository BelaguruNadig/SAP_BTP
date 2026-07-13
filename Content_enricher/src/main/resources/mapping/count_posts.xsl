<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="xml" indent="yes"/>

  <!-- Root template -->
  <xsl:template match="/root">
    <root>
      <xsl:for-each select="users">
        <users>
          <name><xsl:value-of select="name"/></name>
          <username><xsl:value-of select="username"/></username>
          <email><xsl:value-of select="email"/></email>
          <phone><xsl:value-of select="phone"/></phone>
          <location><xsl:value-of select="address/city"/></location>
          <company><xsl:value-of select="company/name"/></company>

          <!-- Count posts belonging to this user -->
          <count_of_posts>
            <xsl:value-of select="count(/root/posts[userId = current()/id])"/>
          </count_of_posts>
        </users>
      </xsl:for-each>
    </root>
  </xsl:template>

</xsl:stylesheet>
