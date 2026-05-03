#!/bin/sh
set -eu

if [ -n "${DATABASE_URL:-}" ] && [ -z "${DB_HOST:-}" ]; then
  DB_HOST="$(printf '%s' "$DATABASE_URL" | sed -E 's#^postgresql://.*@([^:/]+)(:([0-9]+))?/.*#\1#')"
  DB_PORT="$(printf '%s' "$DATABASE_URL" | sed -E 's#^postgresql://.*@[^:/]+:([0-9]+)/.*#\1#')"

  if [ "$DB_PORT" = "$DATABASE_URL" ]; then
    DB_PORT=5432
  fi

  export DB_HOST
  export DB_PORT
fi

echo "Starting Food Fiesta Application..."
exec java -jar app.jar
