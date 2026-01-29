import fs from "fs";
import path from "path";

export function loadDomain(dir) {
  const load = (file) =>
    JSON.parse(fs.readFileSync(path.join(dir, file), "utf8"));

  return {
    units: load("units.json"),
    structure: load("structure.json"),
    attributes: load("attributes.json"),
  };
}

export function compileDomain(domain) {
  // Future place for validation, normalization, indexing, etc.
  return {
    ...domain,
    compiledAt: new Date().toISOString(),
  };
}
